import useCart from 'app/logic/useCart';
import React, {useEffect, useState} from 'react';
import {PizzaService} from 'app/service/PizzaService';
import {Button, message, Spin} from 'antd';
import CartItem from 'app/logic/cart/CartItem';
import 'app/logic/cart/CartPage.css';
import {PizzaOrder} from 'app/model/PizzaOrder';

export default function CartPage() {
    const {cart, isInCart, remove} = useCart();
    const [pizzaOrders, setPizzaOrders] = useState<PizzaOrder[]>([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        PizzaService.getAllPizza('').then((allPizza) => {
            const pizzaOrdersNew = allPizza.content.filter(pizzaItem => isInCart(pizzaItem.id)).map((pizza) => new PizzaOrder(pizza))
                .map((serverItem) => {
                    const order = pizzaOrders.find((prevOrdersItem) => prevOrdersItem.pizza.id === serverItem.pizza.id);
                    if (order) {
                        serverItem.quantity = order.quantity;
                    }
                    return serverItem;
                });
            setPizzaOrders(pizzaOrdersNew);
        }).finally(() => setLoading(false));
    }, [cart, isInCart]);

    return (
        <div className='cart-page'>
            {loading ? <Spin/> :
                <div className='pizza-cart'>
                    {pizzaOrders.map((item) =>
                        <CartItem
                            key={item.pizza.id}
                            setQuantity={getSetterQuantity(item.pizza.id)}
                            pizzaOrder={item}
                            removeFromCart={getHandleRemove(item.pizza.id)}/>)}
                </div>

            }
            {
                !loading && !pizzaOrders.length &&
                <div>Cart is empty</div>
            }
            {
                !loading && !!pizzaOrders.length &&
                <div className='create-order'>
                    <Button onClick={handleCreateOrder}>
                        Create order
                    </Button>
                </div>
            }

        </div>
    )

    function getHandleRemove(id: string) {
        return () => {
            remove(id);
            message.success('Pizza removed from Cart.')
        }
    }

    function getSetterQuantity(id: string) {
        return (number: number) => {
            const pizzaOrder = pizzaOrders.map((item) => {
                if (item.pizza.id === id) {
                    item.quantity = number;
                }
                return item;
            });
            setPizzaOrders(pizzaOrder);
        }
    }

    function handleCreateOrder() {
        console.log(pizzaOrders);
    }
}
