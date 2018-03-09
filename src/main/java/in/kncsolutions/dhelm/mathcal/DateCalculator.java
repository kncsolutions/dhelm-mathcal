/**
 *Copyright 2017 Pallav Nandi Chaudhuri@Knc Solutions Private Limited

  *Licensed under the Apache License, Version 2.0 (the "License");
  *you may not use this file except in compliance with the License.
  *You may obtain a copy of the License at

  * http://www.apache.org/licenses/LICENSE-2.0

  *Unless required by applicable law or agreed to in writing, software
  *distributed under the License is distributed on an "AS IS" BASIS,
  *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *See the License for the specific language governing permissions and
  *limitations under the License.
 */
package in.kncsolutions.dhelm.mathcal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
*
*/
public class DateCalculator{

/**
*@return Returns today's date in yyyy-mm-dd format
*/
public static String getDate(){
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  Date date = new Date();
  return dateFormat.format(date);
}
/**
*@param p:Number of days before the present day for which the date have to be found.
*return Returns the date before p no. of days in yyyy-mm-dd format.
*/
public static String getPrevDate(int p){
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");     
  Calendar cal = Calendar.getInstance(); 
  cal.add(Calendar.DATE, -p); 
  Date myDate = cal.getTime();
  return dateFormat.format(myDate);
}
}