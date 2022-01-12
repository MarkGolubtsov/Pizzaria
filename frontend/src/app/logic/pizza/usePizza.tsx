import {useEffect, useState} from 'react';
import {PizzaService} from 'app/service/PizzaService';
import {Pizza} from 'app/model/Pizza';
import useSearchParams from 'app/logic/useSearchParams';

export default function usePizza() {
    const [pizza, setPizza] = useState<Pizza[]>([]);
    const [loading, setLoading] = useState(false);
    const params = useSearchParams();

    useEffect(() => {
        setLoading(true);
        PizzaService.getAllPizza(params.text).then((response) => {
            setPizza(response.content);
        }).finally(() => setLoading(false));
    }, [params.text]);


    function loadPizza() {
        setLoading(true);
        PizzaService.getAllPizza(params.text).then((response) => {
            setPizza(response.content);
        }).finally(() => setLoading(false));
    }
    return {
        loadPizza,
        pizza,
        loading,
        searchParams: params
    }

}
