using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class HeatedThread
    {

        public int ID { get; set; }
        public int BugID { get; set; }
        public string ThreadPost { get; set; }
        public List<Employee> listEmployee = new List<Employee>();

        public HeatedThread(int ID, int BugID, string ThreadPost)
        {
            this.ID = ID;
            this.BugID = BugID;
            this.ThreadPost = ThreadPost;
        }

    }
}
