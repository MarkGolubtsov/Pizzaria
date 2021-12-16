import React, {ReactElement} from 'react';
import {Navigate, Outlet, useLocation} from 'react-router-dom';

type ComponentWithOutlet = {
    layout?: JSX.Element;
}

export function CustomConditionLayout(access: boolean, redirectPath: string) {
    return function ({layout}: ComponentWithOutlet) {
        // eslint-disable-next-line react-hooks/rules-of-hooks
        const location = useLocation();
        if (access) {
            return layout ? layout : <Outlet/>
        } else {
            return <Navigate to={redirectPath} state={{from: location}}/>
        }
    }
}
