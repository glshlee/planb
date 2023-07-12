import React, { useState } from "react";
import { ListItem, ListItemText, InputBase, Checkbox, ListItemSecondaryAction, IconButton } from "@mui/material"
import DeletedOutlined from "@mui/icons-material/DeleteOutlined"

const Todo = (props) => {
    const [item, setItem] = useState(props.item);
    const [readOnly, setReadOnly] = useState(true);

    const editItem = props.editItem;
    const deleteItem = props.deleteItem;

    const editEventHandler = (e) => {
        setItem({...item, title: e.target.value});
    }

    const deleteEventHandler = () => {
        deleteItem(item);
    }

    const checkboxEventHandler = (e) => {
        item.done = e.target.checked;
        editItem(item);
    }

    const turnOffReadOnly = () => {
        setReadOnly(false);
    }

    const turnOnReadOnly = (e) => {
        if (e.nativeEvent.isComposing === true) {
            return;
        }
        if (e.key == "Enter" && readOnly === false) {
            setReadOnly(true);
            editItem(item);
        }
    }

    return (
        <ListItem>
            <Checkbox checked={item.done} onChange={checkboxEventHandler} />
            <ListItemText>
                <InputBase
                    inputProps={{ "aria-label": "naked", readOnly: readOnly }}
                    onClick={turnOffReadOnly}
                    onKeyDown={turnOnReadOnly}
                    onChange={editEventHandler}
                    type="text"
                    id={item.id}
                    name={item.id}
                    value={item.title}
                    multiline={true}
                    fullWidth={true}
                />
            </ListItemText>
            <ListItemSecondaryAction>
                <IconButton aria-label="Delete Todo" onClick={deleteEventHandler}>
                    <DeletedOutlined />
                </IconButton>
            </ListItemSecondaryAction>
        </ListItem>
    );
};

export default Todo;