import {createContext, useState} from 'react';
import {constants} from 'app/constants';

export const CartContext = createContext<{
    cart: string[],
    remove: (id: string) => void,
    add: (id: string) => void,
    isInCart: (id: string) => boolean,
    clear: () => void,
}>({
        cart: [],
        remove: () => {
        },
        isInCart: () => false,
        add: () => {
        },
        clear: () => {
        }
    }
);

const cartKey = constants.CART_STORAGE_KEY;

const cartFromStorage = localStorage.getItem(cartKey);

const defaultCart: string[] = cartFromStorage ? JSON.parse(cartFromStorage) : [];

export default function CartProvider({children}: { children: JSX.Element | JSX.Element[] }) {
    const [cart, setCart] = useState(defaultCart);


    return (
        <CartContext.Provider value={{
            cart: cart,
            remove: removeCartItem,
            add: addToCart,
            isInCart: isInCart,
            clear: clear
        }}>
            {children}
        </CartContext.Provider>
    )

    function addToCart(pizzaId: string) {
        const updatedCart = [...cart, pizzaId];
        updateCart(updatedCart);
    }

    function removeCartItem(pizzaId: string) {
        const updatedCart = cart.filter(item => item !== pizzaId);
        updateCart(updatedCart);
    }

    function updateCart(updatedCart: string[]) {
        setCart(updatedCart);
        localStorage.setItem(cartKey, JSON.stringify(updatedCart));
    }

    function isInCart(pizzaId: string) {
        return !!cart.find((id) => pizzaId === id);
    }

    function clear() {
        updateCart([]);
    }
}
