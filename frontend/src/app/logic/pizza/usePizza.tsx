import {useEffect, useState} from 'react';
import {PizzaService} from 'app/service/PizzaService';
import {Pizza} from 'app/model/Pizza';

export default function usePizza() {
    const [pizza, setPizza] = useState<Pizza[]>([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        PizzaService.getAllPizza().then((response) => {
            setPizza(response.content);
        }).finally(() => setLoading(false));
    }, [])
    return {
        pizza,
        loading
    }
}
