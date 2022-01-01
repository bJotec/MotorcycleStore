package pl.camp.it.motorcycle.rent.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

        private List<OrderPosition> positions= new ArrayList<>();

        public double calculateSum() {
            double sum= 0.0;
            for (OrderPosition orderPosition : this.positions) {
                sum += orderPosition.getPositionQuantity() * orderPosition.getMotorcycle().getPrice();
            }
            return Math.round(sum * 100) / 100.0;
        }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<OrderPosition> positions) {
        this.positions = positions;
    }
}
