using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace LabWork2
{
    public static class Parser
    {
        public static IEnumerable<Match> MatchesFromFile(string filePath, Regex regEx, int minGroupCount)
        {
            string lines = File.ReadAllText(filePath);
            MatchCollection matches = regEx.Matches(lines);
           
            return matches.Cast<Match>().Where(match => match.Groups.Count > minGroupCount);
        }

        public static int ParseInt(string data)
        {
            if (data.Contains("*")) {
                data = data.Substring(0, data.IndexOf("*", StringComparison.Ordinal));
            }

            return int.Parse(data);
        }
    }
}