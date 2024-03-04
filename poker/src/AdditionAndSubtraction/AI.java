package AdditionAndSubtraction;

import Initialization.Brand;
import User.Player;

public class AI extends Player {
    public AI(String name) {
        super(name);
    }

    public boolean auto(int requiredResults) {
        for (Brand handCard : handCards) {
            int handCardCheckNumber = handCard.getCheckNumber();
            if (requiredResults == handCardCheckNumber) {
                rmHandCards(handCard);
                return false;
            }
            Brand temp = new Brand(0, (Math.abs(requiredResults - handCardCheckNumber)));
            if (handCards.contains(temp)) {
                rmHandCards(handCards.indexOf(temp));
                rmHandCards(handCard);
                return false;
            }
        }
        return true;
    }  // 自动出牌

    @Override
    public String toString() {
        return this.getName() + ":[" + this.getDiscardPile() + "]";
    }
}
