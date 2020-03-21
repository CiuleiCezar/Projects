using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class Employee
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string Position { get; set; }

        public List<HeatedThread> threadList = new List<HeatedThread>();

        public Employee(int ID, string Name, string Position)
        {
            this.ID = ID;
            this.Name = Name;
            this.Position = Position;
        }
    }
}
