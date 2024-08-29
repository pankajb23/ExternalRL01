package io.prophecy.pipelines.pipeline01

import io.prophecy.libs._
import io.prophecy.pipelines.pipeline01.config._
import io.prophecy.pipelines.pipeline01.functions.UDFs._
import io.prophecy.pipelines.pipeline01.functions.PipelineInitCode._
import io.prophecy.pipelines.pipeline01.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_create_dataframe_from_rdd = create_dataframe_from_rdd(context)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Pipeline01")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/Pipeline01")
    registerUDFs(spark)
    MetricsCollector.instrument(spark, "pipelines/Pipeline01") {
      apply(context)
    }
  }

}
