import { StyleSheet } from "react-native";
import { Text, View } from "react-native";
import { TouchableHighlight, TouchableOpacity } from "react-native";
import { useState } from "react/cjs/react.development";

const RenderItemScreen= ({item}) => {
    const {index} = item;
    const itemObj = item.item;
    const [show,setShow] = useState(false);
    // console.log(itemObj);
    return(
        <View style = {styles.itemMargin}>
            <TouchableOpacity onPress={() => setShow(!show)}>
                <Text>{`${index} item.name : ${itemObj.name}`}</Text>
            </TouchableOpacity>
         {
             show?
             <View>
                 <Text>{`item.id : ${item.id}`}</Text>
                 <Text>{`item.password : ${itemObj.password}`}</Text>
            </View>
             :null
         } 
      </View>
    )
}

export default RenderItemScreen;

const styles = StyleSheet.create({
    itemMargin:{
        margin:10,
        
    }

})