package sia.tacocloud.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
