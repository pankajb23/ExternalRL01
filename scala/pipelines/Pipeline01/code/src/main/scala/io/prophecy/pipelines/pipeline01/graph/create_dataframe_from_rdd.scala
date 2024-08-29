package io.prophecy.pipelines.pipeline01.graph

import io.prophecy.libs._
import io.prophecy.pipelines.pipeline01.config.Context
import io.prophecy.pipelines.pipeline01.functions.UDFs._
import io.prophecy.pipelines.pipeline01.functions.PipelineInitCode._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object create_dataframe_from_rdd {
  def apply(context: Context): DataFrame = {
    val spark = context.spark
    val Config = context.config
    val rdd = spark.sparkContext.parallelize(Seq((1, "Alice"), (2, "Bob")))
    val out0 = rdd.toDF("id", "name")
    out0
  }

}
