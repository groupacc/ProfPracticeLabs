using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.IO;
using System.Text.RegularExpressions;

namespace Lab2_Pavliuchenko_318
{
    class GoalsProcessing
    {
        private FileStream fileStream;
        private StreamReader streamReader;

        private String MinGoalDiffTeam;
        private int MinGoalsSpread;

        public GoalsProcessing(String FilePath)
        {
            fileStream = File.Open(FilePath, FileMode.Open);
            streamReader = new StreamReader(fileStream);

            MinGoalsSpread = int.MaxValue;
        }

        private void FindTeamWithMinGoalsSpread()
        {
            while (!streamReader.EndOfStream)
            {
                string s = streamReader.ReadLine();
                Match m = Regex.Match(s, @"^\s+\d+\.\s+(\w+)\s+\d+\s+\d+\s+\d+\s+\d+\s+(\d+)\s+\-\s+(\d+)");

                if (m.Groups.Count > 1)
                {
                    string team = m.Groups[1].ToString();
                    int goalsfor = Convert.ToInt32(m.Groups[2].ToString());
                    int goalsagainst = Convert.ToInt32(m.Groups[3].ToString());
                    int spread = Math.Abs(goalsfor - goalsagainst);

                    if (spread < MinGoalsSpread)
                    {
                        MinGoalsSpread = spread;
                        MinGoalDiffTeam = team;
                    }
                }
            }

            fileStream.Close();
            streamReader.Close();
        }


        public override string ToString()
        {
            FindTeamWithMinGoalsSpread();
            return "Team name\t Goals difference\n" +
                MinGoalDiffTeam + "\t " + MinGoalsSpread.ToString();
        }
    }
}
