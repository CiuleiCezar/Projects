using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class DatabaseLogic
    {
        private const string CONNECTION_STRING = "Server=DESKTOP-986JRQ9;Database=Company;Trusted_Connection=True;";

        public void insertBug(Bug bug)
        {

        }

        public Bug readBygByID(int ID)
        {

            using (SqlConnection connection = new SqlConnection(CONNECTION_STRING))
            {
                connection.Open();

                using (SqlCommand command = connection.CreateCommand())
                {
                    command.CommandType = CommandType.Text;
                    command.CommandText = "SELECT *FROM [dbo].[Product] Where [ID]=@ID";
                    command.Parameters.AddWithValue("@ID", id);

                    SqlDataReader reader = command.ExecuteReader();

                    if (reader.HasRows)
                    {
                        reader.Read();
                        string name = (string)reader["Name"];
                        string description = (string)reader["Description"];
                        string version = (string)reader["Version"];

                        return new Product(id, name, description, version);
                    }

                }
            }

            return null;
        }

    }
}
