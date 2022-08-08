package view;

import java.util.Scanner;

import controller.ClassMemberController;
import dto.MemberDto;

public class View {
    private Scanner scanner;
    private MemberDto[] memberList;

    private ClassMemberController classMemberController;

    public View() {
        // init scanner
        this.scanner = new Scanner(System.in);
        this.memberList = null;
    }
    
    public void display() {
        displayMembers();
        displayMenu();
        boolean isQuit = false;
        while(true) {
            System.out.println("Moi ban chon menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7: {
                    isQuit = true;
                    break;
                }
                default:
                    break;
            }
            if (isQuit == true) {
                break;
            }
        }
        if (isQuit == true) {
            this.quit();
        }
    }

    private void displayMembers() {

        System.out.println("Danh sach lop");
        System.out.printf("%-30s", "Ten");
        System.out.printf("%-10s", "Chuc vu");
        System.out.printf("%-10s", "Gioi Tinh");
        System.out.printf("%-30s", "Email");
        System.out.printf("%-12s", "SDT");
        System.out.println();
        if (memberList == null || memberList.length == 0) {
            System.out.println("Khong co thanh vien nao trong lop");
        } else {
            
        }
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("[1] Refresh");
        System.out.println("[2] Add Teacher");
        System.out.println("[3] Add Student");
        System.out.println("[4] Search keyword");
        System.out.println("[5] View member");
        System.out.println("[6] Remove member");
        System.out.println("[7] Quit");
    }

    private void addNewTeacher() {

        System.out.println("Nhap ten:");
        this.scanner.nextLine();
        System.out.println("Nhap ngay sinh (dd/MM/yyy):");
        this.scanner.nextLine();
        System.out.println("Nhap gioi tinh (Nam/Nu):");
        this.scanner.nextLine();
        System.out.println("Nhap email:");
        this.scanner.nextLine();
        System.out.println("Nhap so dien thoai:");
        this.scanner.nextLine();
        System.out.println("Nhap so nam kinh nghiem:");
        this.scanner.nextLine();
        System.out.println("Nhap linh vuc giang day:");
        this.scanner.nextLine();

    }
    private void addNewStudent() {
        System.out.println("Nhap ten:");
        this.scanner.nextLine();
        System.out.println("Nhap ngay sinh (dd/MM/yyy):");
        this.scanner.nextLine();
        System.out.println("Nhap gioi tinh (Nam/Nu):");
        this.scanner.nextLine();
        System.out.println("Nhap email:");
        this.scanner.nextLine();
        System.out.println("Nhap so dien thoai:");
        this.scanner.nextLine();
        System.out.println("Dang ky hoc online (Y/N):");
        this.scanner.nextLine();
        System.out.println("Nhap background:");
        this.scanner.nextLine();
    }

    private void quit() {
        System.out.println("Hen gap lai !!!");
        this.close();
    }

    // close view
    public void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}
