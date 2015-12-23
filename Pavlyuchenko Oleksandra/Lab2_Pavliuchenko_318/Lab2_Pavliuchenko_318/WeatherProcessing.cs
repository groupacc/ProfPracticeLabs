using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.IO;
using System.Text.RegularExpressions;

namespace Lab2_Pavliuchenko_318
{
    class WeatherProcessing
    {
        private FileStream fileStream;
        private StreamReader streamReader;
        
        private String MinTempSpread;
        private int MinSpread;
        private int MinTemp;
        private int MaxTemp;

        public WeatherProcessing(String FilePath)
        {
            fileStream = File.Open(FilePath, FileMode.Open);
            streamReader = new StreamReader(fileStream);

            MinSpread = int.MaxValue;
        }

        private void FindSmallestTemperatureSpread()
        {
            while (!streamReader.EndOfStream)
            {
                string s = streamReader.ReadLine();
                Match m = Regex.Match(s, @"^\s+(\d+)\s+(\d+)\s+(\d+)");

                if (m.Groups.Count > 1)
                {
                    String day = m.Groups[1].ToString();
                    int maxtemp = Convert.ToInt32(m.Groups[2].ToString());
                    int mintemp = Convert.ToInt32(m.Groups[3].ToString());
                    int minspread = Math.Abs(maxtemp - mintemp);

                    if (minspread < MinSpread)
                    {
                        MinSpread = minspread;
                        MinTempSpread = day;
                        MinTemp = mintemp;
                        MaxTemp = maxtemp;
                    }
                }
            }

            fileStream.Close();
            streamReader.Close();

        }


        public override string ToString()
        {
            FindSmallestTemperatureSpread();
            return "Day number\t Max temperature\t Min temperature\n" +
                MinTempSpread + "\t\t " + MinTemp.ToString() + "\t\t\t " + MaxTemp.ToString();        
        }
    }
}
