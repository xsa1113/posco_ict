import { useState } from "react";
import {Data} from "./Data";
import SearchBar from "./SearchBar";
// import Table from "./Table";

const FilterableTable = () => {

    const [isCheck, setIsCheck] = useState(false);
    const [filterText, setFilterText] = useState("");

    
    return(
        <div>
            <SearchBar isCheck={isCheck} setIsCheck={setIsCheck} filterText={filterText} setFilterText={setFilterText}></SearchBar>
            {/* <Table data={Data} isCheck={isCheck} filterText={filterText}></Table> */}
        </div>
    )
};

export default FilterableTable;