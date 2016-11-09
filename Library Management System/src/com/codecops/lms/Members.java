package com.codecops.lms;

import com.codecops.services.Database;

public class Members extends Users {

    private int[] issuedBooks = new int[3];

    public Members(int id, String name, long phone, String passwd) {

        super.userId = id;
        super.name = name;
        super.mobileNumber = phone;
        super.passwd = passwd;

    }

    public int getUserId() {
        return super.userId;
    }

    public void setUserId(int userId) {
        super.userId = userId;
    }

    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public long getMobileNumber() {
        return super.mobileNumber;
    }

//    public void setIssuedBooks(int[] issuedBooks) {
//        this.issuedBooks = issuedBooks;
//    }

    public String getIssuedBooks() {
    	String issuedBookDetail="";
    	for(int index=0;index<issuedBooks.length;index++){
    		issuedBookDetail=issuedBookDetail.concat("\t\t"+issuedBooks[index]);
    	}
    	return issuedBookDetail;
    }

    public void setMobileNumber(long mobileNumber) {
        super.mobileNumber = mobileNumber;
    }

    public String getPasswd() {
        return super.passwd;
    }

    public void setPasswd(String passwd) {
        super.passwd = passwd;
    }

    public static boolean loginCheck(Database database, int memberID,
            String memberPassword) {

        for (Members member : database.membersList) {
            if (memberID == member.getUserId()
                    && memberPassword.equals(member.getPasswd())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addIssuedBooks(int bookId){
        for (int index = 0; index < issuedBooks.length; index++) {
                if (issuedBooks[index] == 0){
                        issuedBooks[index] = bookId;
                        return true;
                }
        }
        return false;
    }
    public boolean removeIssuedBooks(int bookId){
        for (int index = 0; index < issuedBooks.length; index++) {
                if (issuedBooks[index] == bookId){
                        issuedBooks[index] = 0;
                        return true;
                }
        }
        return false;
    }
}
