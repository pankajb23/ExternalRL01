package abhishekse2etestsprophecyioteam.scalaexternal01.gems

import io.prophecy.gems._
import io.prophecy.gems.dataTypes._
import io.prophecy.gems.uiSpec._
import io.prophecy.gems.diagnostics._
import io.prophecy.gems.componentSpec._
import org.apache.spark.sql.{DataFrame, SparkSession}
import io.prophecy.gems.copilot._
import play.api.libs.json.{Format, OFormat, JsResult, JsValue, Json}


class Gem01 extends ComponentSpec {

  val name: String = "Gem01"
  val category: String = "Transform"
  type PropertiesType = Gem01Properties
  override def optimizeCode: Boolean = true

  case class Gem01Properties(
    @Property("Property1")
    property1: String = ""
  ) extends ComponentProperties

  implicit val Gem01PropertiesFormat: Format[Gem01Properties] = Json.format

  def dialog: Dialog = Dialog("Gem01")

  def validate(component: Component)(implicit context: WorkflowContext): List[Diagnostic] = Nil

  def onChange(oldState: Component, newState: Component)(implicit context: WorkflowContext): Component = newState

  def deserializeProperty(props: String): Gem01Properties = Json.parse(props).as[Gem01Properties]

  def serializeProperty(props: Gem01Properties): String = Json.toJson(props).toString()

  class Gem01Code(props: PropertiesType) extends ComponentCode {
    def apply(spark: SparkSession, in: DataFrame): DataFrame = {
      val out = in
      out
    }
  }
}
