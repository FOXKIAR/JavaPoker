package Initialization;

public class Brand {
    private String cardType; //牌型
    private int checkNumber; // 点数
    private String decor = ""; // 花色
    private int decorNumber;

    public Brand() {}

    public Brand(int decor, int checkNumber) {
        setDecor(decor);
        setCheckNumber(checkNumber);
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDecor() {
        return decor;
    }

    public void setCheckNumber(int checkNumber) {
        if (checkNumber > 15 || checkNumber <= 0) {
            System.err.println("出现严重错误，没有此类牌型");
            System.exit(500);
        }
        this.checkNumber = checkNumber;
        switch (checkNumber) {
            case 1 -> this.cardType = "A";
            case 11 -> this.cardType = "J";
            case 12 -> this.cardType = "Q";
            case 13 -> this.cardType = "K";
            case 14 -> this.cardType = "小王";
            case 15 -> this.cardType = "大王";
            default -> this.cardType = "" + checkNumber;
        }
    }  // 根据点数设置牌型

    public void setDecor(int decorNumber) {
        if (decorNumber > 4 || decorNumber < 0) {
            System.err.println("出现严重错误，没有此类花色");
            System.exit(500);
        }
        this.decorNumber = decorNumber;
        switch (decorNumber) {
            case 4 -> this.decor = "黑桃";
            case 3 -> this.decor = "红桃";
            case 2 -> this.decor = "梅花";
            case 1 -> this.decor = "方片";
        }
    }  // 根据花点设置花色

    public int getDecorNumber() {
        return decorNumber;
    }

    @Override
    public String toString() {
        return this.decor + this.cardType;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && ((Brand) obj).getCheckNumber() == this.checkNumber;
    }
}