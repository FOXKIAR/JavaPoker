package User;

import Initialization.Brand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    protected List<Brand> handCards; // 手牌
    protected List<Brand> discardPile; // 弃牌
    private String name; // 名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Brand> getHandCards() {
        return handCards;
    }

    public List<Brand> getDiscardPile() {
        return discardPile;
    }

    public Player(String name) {
        handCards = new ArrayList<>();
        discardPile = new ArrayList<>();
        this.name = name;
    }
    
    public Player() {
        handCards = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    public void addHandCards(Brand brand) {
        handCards.add(brand);
    }  // 接1张牌

    public void addHandCards(Brand... brands) {
        handCards.addAll(Arrays.asList(brands));
    }  // 接多张牌

    public void rmHandCards(Brand... brands) {
        for (Brand brand : brands) {
            handCards.remove(brand);
            discardPile.add(brand);
            // 出牌后将出过的牌从手牌移动至个人弃牌堆中
        }
    }  // 按对象出牌

    public void rmHandCards(int... brandIndex) {
        for (int index : brandIndex)
            rmHandCards(handCards.get(index));
    }  // 按索引出牌

    public void sortHandCards() {
        int handCardsCount;
        if ((handCardsCount = handCards.size()) <= 1)
            return;
        List<Brand> newBrands = new ArrayList<>();
        Brand minBrand, temp;
        for (int i = 0; i < handCardsCount; i++) {
            minBrand = handCards.getFirst();
            for (Brand handCard : handCards) {
                temp = handCard;
                if (minBrand.getCheckNumber() < temp.getCheckNumber()) continue;
                if (minBrand.getCheckNumber() > temp.getCheckNumber() || minBrand.getDecorNumber() > temp.getDecorNumber())
                    minBrand = temp;
            }
            newBrands.add(minBrand);
            handCards.remove(minBrand);
        }
        handCards = newBrands;
    }  // 整理手牌

    public void rmDiscardPileAll() {
        this.discardPile = new ArrayList<>();
    }

    public boolean isWinVictory() {
        if (handCards.isEmpty()) {
            System.out.println(name + "获胜");
            return false;
        } else
            return true;
    }
}
