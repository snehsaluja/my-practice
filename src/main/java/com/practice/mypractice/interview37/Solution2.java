package com.practice.mypractice.interview37;

// saviynt round 2:

public class Solution2 {


/*
    public void importCsvToDB(String filePath) {

        FileInputStream ip = new FileInputStream(filePath);

        */
/* while (ip.hasMoreEntries()) {
            List<String> row = ip.getEntries();
            User user = getUser(row);
            userRrepository.save(user);
        }*//*


        try {
            Connection conn = getConnection();

            while (ip.hasMoreElements()) {
                int len = 1000;
                List<User> listUser = new ArrayList<>();
                while (ip.hasMoreEntries() && len < 1000) {
                    List<String> row = ip.getEntries();
                    User user = getUser(row);
                    listUser.add(user);
                }
                conn.saveAll(listUser);
                conn.commit();
            }
            conn.close();
        } catch (Execption e) {

        }

    }
*/
}


// csv file 20 cols - 10M row,
// Table with 20 cols in DB


// Table A left join on Table B user_id

// Table B right join Table A
