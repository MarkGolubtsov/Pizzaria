import {useState} from 'react';

export default function useSearchParams() {
    const [text, setText] = useState('');

    return {
        text,
        handleChangeText
    }

    function handleChangeText(text: string) {
        setText(text);
    }
}
