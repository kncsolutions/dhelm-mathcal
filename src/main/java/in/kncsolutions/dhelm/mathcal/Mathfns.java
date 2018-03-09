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
 import java.util.*;
 public class Mathfns{
 /**
 *@param num : The number which is to be truncated to two digits after decimal point.
 *@return : returns the truncated number. 
 */
   public static double truncate(double num){
     return Math.floor(num*100)/100;	 
   } 
  /**
  *@param input : input list which have to be reversed.
  *@return the reverse list is returned.
  */ 
  public static List<Double> reverse(List<Double> input){
    List<Double> output=new  <Double>ArrayList();
	for(int i=input.size()-1;i>=0;i--){
	  output.add(input.get(i));
	}
	return output;
  }
  /**
  *@param data: list of y values.
  *@param np: range of x starting from 1.
  *@return returns the parameters of line in terms of an array of size two where the first element is the slope in degrees and second element is the y-intercept.
  */
  public static double[] ComputeTrendLine(List<Double>data,int np) {
       double[] trendline=new double[2];
       trendline[0]=0;
       trendline[1]=0;
       int size=0;
       double xb=0,yb=0;
       double num=0,den=0,m=0,b=0;
       if(np<data.size())size=np;
       else size=data.size();
       if(size!=0){
        for(int i=0;i<size;i++){
            xb=xb+i+1;
            yb=yb+data.get(i); 
        }
        xb=xb/size;
        yb=yb/size;
        for(int i=0;i<size-1;i++){
            num=num+((i+1-xb)*(data.get(i)-yb));
            den=den+((i+1-xb)*(i+1-xb));
        }
        m=num/den;
        b=yb-m*xb;
        trendline[0]=Math.toDegrees(Math.atan(m));
        trendline[1]=b;
    }
       return trendline;
    }
     /**
  *@param data: list of y values.
  *@param np: range of x starting from 1.
  *@return returns the parameters of line in terms of an array of size two where the first element is the slope in degrees and second element is the y-intercept.
  */
  public static double[] ComputeTrendVolume(List<Long>data) {
       double[] trendline=new double[2];
       trendline[0]=0;
       trendline[1]=0;
       int size=0;
       int xb=0;
       long yb=0;
       double num=0,den=0,m=0,b=0;
       size=data.size();
       if(size!=0){
        for(int i=0;i<size;i++){
            xb=xb+i+1;
            yb=yb+data.get(i); 
        }
        xb=xb/size;
        yb=yb/size;
        for(int i=0;i<size-1;i++){
            num=num+((i+1-xb)*(data.get(i)-yb));
            den=den+((i+1-xb)*(i+1-xb));
        }
        m=num/den;
        b=yb-m*xb;
        trendline[0]=Math.toDegrees(Math.atan(m));
        trendline[1]=b;
    }
       return trendline;
    }

	/**
  *@param data: list of y values.
  *@param data: list of x values.
  *@return returns the parameters of line in terms of an array of size two where the first element is the slope in degrees and second element is the y-intercept.
  */
	public static double[] ComputeTrendLine(List<Double>data,List<Integer>dataX) {
       double[] trendline=new double[2];
       trendline[0]=0;
       trendline[1]=0;
       int size=0;
       double xb=0,yb=0;
       double num=0,den=0,m=0,b=0;
       size=data.size();
       if(size!=0){
        for(int i=0;i<size;i++){
            xb=xb+dataX.get(i)+1;
            yb=yb+data.get(i);
        }
        xb=xb/size;
        yb=yb/size;
        for(int i=0;i<size-1;i++){
            num=num+((i+1-xb)*(data.get(i)-yb));
            den=den+((i+1-xb)*(i+1-xb));
        }
        m=num/den;
        b=yb-m*xb;
        trendline[0]=Math.toDegrees(Math.atan(m));
        trendline[1]=b;
    }
       return trendline;
    }
    /**
  *@param points: x-y cordinates of the points of the line for which trend have to be calculated.  
  *@return returns the parameters of line in terms of an array of size two where the first element is the slope in degrees and second element is the y-intercept.
  */
	public static double[] ComputeTrendLine(List<XYPoint> points) {
       List<Double> data=new ArrayList<Double>();
       List<Integer> dataX=new ArrayList<Integer>();
       double[] trendline=new double[2];
       trendline[0]=0;
       trendline[1]=0;
       int size=0;
       double xb=0,yb=0;
       double num=0,den=0,m=0,b=0;
       size=points.size();
       for(int j=0;j<points.size();j++){
         data.add(points.get(j).Y);
         dataX.add(points.get(j).X);
       }
       if(size!=0){
        for(int i=0;i<size;i++){
            xb=xb+dataX.get(i)+1;
            yb=yb+data.get(i);
        }
        xb=xb/size;
        yb=yb/size;
        for(int i=0;i<size-1;i++){
            num=num+((i+1-xb)*(data.get(i)-yb));
            den=den+((i+1-xb)*(i+1-xb));
        }
        m=num/den;
        b=yb-m*xb;
        trendline[0]=Math.toDegrees(Math.atan(m));
        trendline[1]=b;
    }
       return trendline;
    }

 }