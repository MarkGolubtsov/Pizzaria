import {Button, Form, Input, InputNumber, message} from 'antd';
import AppForm from 'app/components/AppForm';
import 'app/logic/create-pizza/CreatePizzaPage.css';
import TextArea from 'antd/es/input/TextArea';
import {useForm} from 'antd/es/form/Form';
import {Pizza} from 'app/model/Pizza';
import {PizzaService} from 'app/service/PizzaService';

export default function CreatePizzaPage() {
    const [form] = useForm();

    return (
        <div className='create-pizza-page'>
            <AppForm className='create-pizza-form' layout="vertical" form={form} onFinish={handleCreate}  style={{
                marginTop: 20
            }}>
                <Form.Item style={{
                    width: 500
                }} name='name' label='Name' rules={[{required: true, message: 'Provide Name'}]}>
                    <Input/>
                </Form.Item>
                <Form.Item style={{
                    width: 500
                }} name='description' label='Description'
                           rules={[{required: true, message: 'Provide Description'}]}>
                    <TextArea/>
                </Form.Item>
                <Form.Item style={{
                    width: 500
                }} name='price' label='Price' rules={[{required: true, message: 'Provide Price'}]}>
                    <InputNumber min={1} max={10000}  style={{
                        width: 500
                    }}/>
                </Form.Item>
                <Form.Item name='weight' label='Weight' rules={[{required: true, message: 'Provide Weight'}]} style={{
                    width: 500
                }}>
                    <InputNumber min={1} max={10000}  style={{
                        width: 500
                    }}/>
                </Form.Item>
                <Form.Item>
                    <Button htmlType='submit'>
                        Create Pizza
                    </Button>
                </Form.Item>
            </AppForm>
        </div>
    )

    function handleCreate(values: Pizza) {
        PizzaService.createPizza(values)
            .then(() => {
                message.success('Pizza created.')
            })
            .finally(() => {
                form.resetFields();
            })
    }
}
