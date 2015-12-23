using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.IO;
using System.Text.RegularExpressions;

namespace Lab2_Pavliuchenko_318
{
    class DataProcessing
    {
        private FileStream fileStream;
        private StreamReader streamReader;

        private String regex;

        private String ItemWithMinValue;
        private int MinValue;
        private int MaxValue;
        private int MinSpreadValue;

        
        public DataProcessing(String FilePath, String regex)
        {
            fileStream = File.Open(FilePath, FileMode.Open);
            streamReader = new StreamReader(fileStream);

            this.regex = regex;

            MinSpreadValue = int.MaxValue;
        }

        private void FindItemWithMinSpread()
        {
            while (!streamReader.EndOfStream)
            {
                string s = streamReader.ReadLine();
                Match m = Regex.Match(s, regex);
                if (m.Groups.Count > 1)
                {
                    string item = m.Groups[1].ToString();
                    int maxvalue = Convert.ToInt32(m.Groups[2].ToString());
                    int minvalue = Convert.ToInt32(m.Groups[3].ToString());
                    int spread = Math.Abs(maxvalue - minvalue);

                    if (spread < MinSpreadValue)
                    {
                        MinSpreadValue = spread;
                        ItemWithMinValue = item;
                        MaxValue = maxvalue;
                        MinValue = minvalue;
                    }

                }
            }

            fileStream.Close();
            streamReader.Close();
        }

        public override string ToString()
        {
            FindItemWithMinSpread();
            if (regex == @"^\s+(\d+)\s+(\d+)\s+(\d+)")
            {
                return ItemWithMinValue + "\t\t " + MinValue.ToString() + "\t\t\t " + MaxValue.ToString();           
            }
            else
            {
                return ItemWithMinValue + "\t " + MinSpreadValue.ToString();          
            }
        }
    }
}
