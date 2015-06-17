import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}

class SparkSpec extends FlatSpec with BeforeAndAfterAll {

  var sparkConf: SparkConf = null
  var sparkContext: SparkContext = null

  override def beforeAll() {
    sparkConf = new SparkConf()
      .setMaster(s"local[${Runtime.getRuntime().availableProcessors() - 1}]")
      .setAppName("spark-sample")

    sparkContext = new SparkContext(sparkConf)
  }

  override def afterAll() {
    sparkContext.stop()
  }
}
