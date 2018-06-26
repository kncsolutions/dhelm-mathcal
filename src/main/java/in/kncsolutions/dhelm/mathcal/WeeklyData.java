/**
*Copyright 2018 Pallav Nandi Chaudhuri@Knc Solutions Private Limited

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
/**
*
*/
public class WeeklyData{
public  List<Double>   open=  new ArrayList<Double>();
public  List<Double>   high=  new ArrayList<Double>();
public  List<Double>   low=   new ArrayList<Double>();
public  List<Double>   close= new ArrayList<Double>();
public  List<String>   date=  new ArrayList<String>();
public  List<Long>     volume= new ArrayList<Long>();
private List<Double>  dopen=  new ArrayList<Double>();
private List<Double>  dhigh=  new ArrayList<Double>();
private List<Double>  dlow=   new ArrayList<Double>();
private List<Double>  dclose= new ArrayList<Double>(); 
private List<Long>    dvolume=new ArrayList<Long>();
private List<String>  ddate=  new ArrayList<String>();
private List<Integer> day=    new ArrayList<Integer>();
/**
*@param o : list of opening prices on daily basis where first item is the latest data. 
*@param h : list of high prices on daily basis where first item is the latest data.
*@param l : list of low prices on daily basis where first item is the latest data.
*@param c : list of closing prices on daily basis where first item is the latest data.
*@param v : list of volume data on daily basis where first item is the latest data.
*@param ts : list of time stamps in yyyy-mm-dd format  where first item is the latest date for which data is available.
*/
public WeeklyData(List<Double> o, List<Double> h, List<Double> l, List<Double>c, List<Long>v, List<String> ts){
  dopen.addAll(o);
  dhigh.addAll(h);
  dlow.addAll(l);
  dclose.addAll(c);
  dvolume.addAll(v);
  ddate.addAll(ts);
  if(dopen.size() == dhigh.size() && dopen.size() == dlow.size() && dopen.size() == dclose.size()
    && dopen.size()==dvolume.size() && dopen.size() == ddate.size() && dopen.size()>1)
    WeeklyData();
} 
/**
*
*/
private void WeeklyData(){
  Calendar c=Calendar.getInstance();       
  SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");       
  Locale l=Locale.US;
  DateFormat d=new SimpleDateFormat("EEEE");
  long tmp_vol=0;
  double tmp_low=0;
  double tmp_high=0;
  try{
  for(int i=0;i<ddate.size();i++){
    Date dt=f.parse(ddate.get(i));
    c.setTime(dt);
    int dayOfWeek=c.get(Calendar.DAY_OF_WEEK);
    day.add(dayOfWeek);
  }
  }
  catch(ParseException ex){
    ex.printStackTrace();
  }
  for(int i=0;i<day.size()-1;i++){
    if(i==0){
      close.add(dclose.get(i));
      date.add(ddate.get(i));
      tmp_vol=dvolume.get(i);
      tmp_low=dlow.get(i);
      tmp_high=dhigh.get(i);
      if(day.get(i)==2){
         open.add(dopen.get(i));
         high.add(tmp_high);
         low.add(tmp_low);
         volume.add(tmp_vol);   
      }
     }
     else if(i>=1){
       if(day.get(i)<day.get(i-1)){
         tmp_vol=tmp_vol+dvolume.get(i);
         if(dlow.get(i)<tmp_low)tmp_low=dlow.get(i);
         if(dhigh.get(i)>tmp_high)tmp_high=dhigh.get(i);
         if(day.get(i)<day.get(i+1) || i+1==day.size()-1){
           open.add(dopen.get(i));
           high.add(tmp_high);
           low.add(tmp_low);
           volume.add(tmp_vol);
         }
       }//if(day.get(i)<day.get(i-1)){
      else if(day.get(i)>day.get(i-1)){
        close.add(dclose.get(i));
        date.add(ddate.get(i));
        tmp_vol=dvolume.get(i);
        tmp_low=dlow.get(i);
        tmp_high=dhigh.get(i);  
      }
    }
            
 }//for(int i=0;i<day.size();i++){
} 
/**
*@return weekly opening data, where first item is the latest data.
*/
public List<Double> getOpen(){
  return open;
}
/**
*@return weekly high data, where first item is the latest data.
*/
public List<Double> getHigh(){
  return high;
}

/**
*@return weekly low data, where first item is the latest data.
*/
public List<Double> getLow(){
  return low;
}

/**
*@return weekly closing data, where first item is the latest data.
*/
public List<Double> getClose(){
  return close;
}

/**
*@return weekly volume data, where first item is the latest data.
*/
public List<Long> getVolume(){
  return volume;
}

/**
*@return dates for the closing data, where first item is the latest data.
*/
public List<String> getDate(){
  return date;
}

}