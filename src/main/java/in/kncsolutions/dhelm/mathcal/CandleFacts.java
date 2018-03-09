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
 * 
 */
 package in.kncsolutions.dhelm.mathcal;
 import java.util.*; 
 import in.kncsolutions.dhelm.exceptions.DataException;
 /**
 *
 */
 public class CandleFacts{
 
 /**
 *@param oh : List of open/high prices where last element is the latest data.
 *@param cl : List of closing/low prices where last element is the latest data.
 *@param numPeriods: Number of previous periods going back from the latest period to past over which the average  have to be calculated. 
 *@return : returns the average length over the specified number of periods. 
 */
 public static double getAverageLength(List<Double> oh, List<Double> cl , int numPeriods)throws DataException{
   double avg_length=0;
   if(oh.size()<numPeriods && cl.size()<numPeriods){
     throw new DataException();
   }
   else{
    for(int i=0;i<numPeriods;i++){
        avg_length=avg_length+Math.abs((oh.get(i)-cl.get(i)));
    }
    avg_length=avg_length/numPeriods;
	}
    return avg_length;
 }
 /**
 *@param o : the list which is to be reversed
 @return The reversed list
 */
 public static List<Double> reverseDouble(List<Double> o){
   List<Double> r=new <Double>ArrayList();
   for(int i=o.size()-1;i>=0;i--)r.add(o.get(i));
   return r;
 }
 /**
 *@param o : the list which is to be reversed
 @return The reversed list
 */
 public static List<Long> reverseLong(List<Long> o){
   List<Long> r=new <Long>ArrayList();
   for(int i=o.size()-1;i>=0;i--)r.add(o.get(i));
   return r;
 }

/**
 *@param o : the list which is to be reversed
 @return The reversed list
 */
 public static List<String> reverseString(List<String> o){
   List<String> r=new <String>ArrayList();
   for(int i=o.size()-1;i>=0;i--)r.add(o.get(i));
   return r;
 }

 }