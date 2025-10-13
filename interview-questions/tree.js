import React, { useState } from 'react';

const fileTree = {
    id: 1,
    name: "root",
    children: [
        { id: 2, name: "index.js" },
        { id: 3, name: "styles.css" },
        {
            id: 4,
            name: "components",
            children: [
                { id: 5, name: "Header.js" },
                { id: 6, name: "Footer.js" }
            ]
        }
    ]
};

export function App(props) {
    [tree, setTree] = useState(fileTree);
    return (
        <div className='App'>
            <ul>
                <li id={'tree_index_' + tree.id}> {tree.name}
                    {tree.children.length ? tree.children.map(c1 => <ul>
                        <li id={'tree_index_' + tree.id}> {tree.name}</li>
                    </ul>) : ""}
                    <ul>
                        <li id={'tree_index_' + tree.id}> {tree.name}</li>

                    </ul>

                </li>
            </ul>
        </div>
    );
}

