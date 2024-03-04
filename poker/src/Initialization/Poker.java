package Initialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    private List<Brand> brands;

    public Poker(String type, int count) {
        if ("正常".equals(type)) brands = normal(count);
        if ("不含大小王".equals(type)) brands = noJoker(count);
        if (brands == null) {
            System.err.println("出现严重错误，扑克没有创建成功");
            System.exit(500);
        }
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public Brand licensing() {
        Brand brand = brands.getFirst();
        brands.removeFirst();
        return brand;
    }  // 发牌

    private List<Brand> normal(int count) {
        List<Brand> brandList;
        brandList = noJoker(count);
        brandList.add(new Brand(0, 14));
        brandList.add(new Brand(0, 15));
        return brandList;
    }  // 正常

    private List<Brand> noJoker(int count) {
        List<Brand> brandList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (int checkNumber = 1; checkNumber <= 13; checkNumber++) {
                for (int decor = 1; decor <= 4; decor++) {
                    brandList.add(new Brand(decor, checkNumber));
                }
            }
        }
        return brandList;
    }  // 不含大小王

    public void shuffle() {
        Collections.shuffle(brands);
    }  // 洗牌

    public void addBrands(List<Brand> brands) {
        this.brands.addAll(brands);
    }  // 回收弃牌

    @Override
    public String toString() {
        return this.brands.toString();
    }
}