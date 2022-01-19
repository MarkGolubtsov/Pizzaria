import useCart from 'app/logic/useCart';
import React, {useEffect, useState} from 'react';
import {PizzaService} from 'app/service/PizzaService';
import {Button, Input, message, Spin} from 'antd';
import CartItem from 'app/logic/cart/CartItem';
import 'app/logic/cart/CartPage.css';
import {PizzaOrder} from 'app/model/PizzaOrder';
import {OrderService} from 'app/service/OrderService';

export default function CartPage() {
    const {cart, isInCart, remove, clear} = useCart();
    const [pizzaOrders, setPizzaOrders] = useState<PizzaOrder[]>([]);
    const [contact, setContact] = useState('');
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
                !loading && <>
                    {!pizzaOrders.length && <div>Корзина пуста</div>}
                    <div className='contact-input'>
                        <div className='contact-input__label'>Контакт:</div>
                        <Input value={contact} onChange={(e) => setContact(e.target.value)}/>
                    </div>
                    {!!pizzaOrders.length && !!contact &&
                        <div className='create-order'>
                            <Button onClick={handleCreateOrder}>
                                Создать заказ
                            </Button>
                        </div>}
                </>
            }
            {
            }

        </div>
    )

    function getHandleRemove(id: string) {
        return () => {
            remove(id);
            message.success('Пицца удалена из заказа')
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
        OrderService.createOrder(pizzaOrders, contact).then(() => {
            clear();
        });
    }
}
