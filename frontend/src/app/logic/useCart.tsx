import {useContext} from 'react';
import {CartContext} from 'app/logic/CartProvider';


export default function useCart() {
    return useContext(CartContext)
}
