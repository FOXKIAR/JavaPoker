package AdditionAndSubtraction;

import Initialization.Poker;

public class Main {
    public static void main(String[] args) {
        twoAI();
    }

    private static void twoAI() {
        Poker poker = new Poker("不含大小王", 1);
        // 创建一副不含大小王的扑克牌
        poker.shuffle();
        // 洗牌
        AI ai1 = new AI("机器人1");
        // 创建人机1
        AI ai2 = new AI("机器人2");
        // 创建人机2
        for (int i = 0; i < 5; i++) {
            ai1.addHandCards(poker.licensing());
            ai2.addHandCards(poker.licensing());
        }  // 给双方各发牌5张
        ai1.sortHandCards(); ai2.sortHandCards();
        // 双方整理手牌

        ai1.rmHandCards(0);
        System.out.println(ai1);
        poker.addBrands(ai1.getDiscardPile());
        ai1.rmDiscardPileAll();
        // ai1先手出了手牌的第一张

        for (int i = 1; ai1.isWinVictory() && ai2.isWinVictory(); i ++) {
            if (i == 2) {
                i = 0;
                while (ai1.auto(poker.getBrands().getLast().getCheckNumber()))
                    ai1.addHandCards(poker.licensing());
                System.out.println(ai1);
                poker.addBrands(ai1.getDiscardPile());
                ai1.rmDiscardPileAll();
            } else {
                while (ai2.auto(poker.getBrands().getLast().getCheckNumber()))
                    ai2.addHandCards(poker.licensing());
                System.out.println(ai2);
                poker.addBrands(ai2.getDiscardPile());
                ai2.rmDiscardPileAll();
            }
        }

    }
}
