using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabWork1
{
    public class LessThanZeroException : Exception
    {
        public LessThanZeroException(string s) : base(s) {}
    }
}
