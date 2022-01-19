import {PizzaOrder} from 'app/model/PizzaOrder';
import {Button, InputNumber} from 'antd';

type CartItemProps = {
    pizzaOrder: PizzaOrder,

    setQuantity: (number: number) => void,

    removeFromCart: () => void;
}

export default function CartItem({pizzaOrder, setQuantity, removeFromCart}: CartItemProps) {
    return (
        <div className='cartItem'>
            {pizzaOrder.pizza.name}
            <div className='cart-item-count'>
                <InputNumber min={1} value={pizzaOrder.quantity} onChange={setQuantity}/>
            </div>
            <div className='cart-item-remove'>
                <Button danger onClick={removeFromCart}>
                    Удалить из корзины
                </Button>
            </div>
        </div>
    )
}
