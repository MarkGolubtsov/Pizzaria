import React from 'react';
import useAuth from 'app/useAuth';


export default function PizzaOrdersPage() {
    const {logout} = useAuth();

    return (
        <div className='pizza-orders'>
            Pizza orders
            <span onClick={logout}>Logout</span>
        </div>
    )
}
