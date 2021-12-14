import React, {useState} from 'react';
import {Form, FormProps} from 'antd';
import {ValidateErrorEntity} from 'rc-field-form/lib/interface';

type AppFormProps = {} & FormProps;

type ValidateTriggerType = 'onSubmit' | 'onChange';

export default function AppForm(props: AppFormProps) {
    const [validateTrigger, setValidateTrigger] = useState<ValidateTriggerType>('onSubmit');

    return (
        <Form validateTrigger={validateTrigger} {...props} onFinishFailed={onFinishFailed}/>
    )

    function onFinishFailed(errorInfo: ValidateErrorEntity) {
        setValidateTrigger('onChange');

        props.onFinishFailed && props.onFinishFailed(errorInfo);
    }
}
