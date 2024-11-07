package org.example;

public class Loan {

    private int id;
    private int bookIsbn;
    private int memberId;
    private String loanDate;
    private String dueDate;
    private String status;

    public Loan(int bookIsbn, int id, int memberId, String loanDate, String dueDate, String status) {
        this.bookIsbn = bookIsbn;
        this.id = id;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookIsbn=" + bookIsbn +
                ", memberId=" + memberId +
                ", loanDate='" + loanDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
