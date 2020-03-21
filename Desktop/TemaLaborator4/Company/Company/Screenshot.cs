using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class Screenshot
    {

        public int ID { get; set; }
        public int BugID { get; set; }
        public string Path { get; set; }
        public string Description { get; set; }

        public Screenshot(int ID, int BugID, string Path, string Description)
        {
            this.ID = ID;
            this.BugID = BugID;
            this.Path = Path;
            this.Description = Description;
        }

    }
}
