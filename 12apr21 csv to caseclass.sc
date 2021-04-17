import scala.io.Source
var i = 0
//if case class is defined after importing document, first row headers could
// potentially be used as constructor names instead of hard coding.
case class DataPoint(
                      instance: Int,
                      country: String,
                      regionCode: String,
                      regionName: String,
                      latitude: Double,
                      longitude: Double,
                      locationGeon:String,
                      hospitalized: Int,
                      recovered: Int,
                      deaths: Int) //defines case class 'DataPoint'
{
  i = i+1;
  if (i <=1) {println(i + " Data Point has been instantiated!")}
  if (i >1) {println(i + " Data Points have been instantiated!")}
  if (hospitalized > 50) {println(regionName + s" is sketchy because there have been $hospitalized hospitalizations")}
} //counts number of data points that have been instantiated
//also says whether there have been >50 hospitalizations or not

val fileName = "C:\\Users\\Ryan\\Documents\\Coding\\coviddataset.csv" //file handle
//user will need to manually replace fileName string with file location on local computer for now
for (line <- Source.fromFile(fileName).getLines.drop(1)) {//gets lines except 1st row

  val listForm = line.split(",").toList //splits rows into individ. columns
  //println(listForm)
  //println(listForm(0).toInt)
  //println(listForm(1)) (here I was testing to make sure I could access individual elements of a list
  val caseClassForm = DataPoint(listForm(0).toInt,listForm(1),listForm(2),listForm(3),listForm(4).toDouble,listForm(5).toDouble,listForm(6),listForm(7).toInt,listForm(8).toInt,listForm(9).toInt)
  //line above makes new instances of datapoint.type
  println(caseClassForm) //prints new instances of data point type
}
