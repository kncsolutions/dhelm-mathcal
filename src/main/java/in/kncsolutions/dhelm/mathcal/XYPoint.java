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
/**
*This class is to be used to store a 2D point on a chart, where X-cooedinate value represents a particular
*time and Y-coordinate value represents price at that time.
*/
public class XYPoint{
public double Y;
public int X;
/**
*@param x : X-coordinate of the point.
@param y : Y-coordinate of the point.
*/
public XYPoint(int x, double y){
        this.X=x;
        this.Y=y;
    }
    
}
