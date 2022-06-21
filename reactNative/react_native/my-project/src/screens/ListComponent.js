import { FlatList, StyleSheet, Text, View } from 'react-native';
import { TouchableHighlight } from 'react-native';
import { useState } from "react/cjs/react.development";

const ListComponent = () => {
    const [show, setShow] = useState(false);
   const data = [
      { name: 'park', id: 'park', password: '1234', show:false },
      { name: 'lee', id: 'lee', password: '1234' ,show:false },
      { name: 'kang', id: 'kang', password: '1234',show:false  },
      { name: 'kim', id: 'kim', password: '1234' ,show:false },
   ];
   return <FlatList data={data} renderItem={(item,index) => renderItem(item)}></FlatList>;
};

// const [show, setShow] = useState(false);
const onPress = (item,index) =>{
    console.log(item.show)
    console.log(index)
    // setShow(true)


}


export default ListComponent;
const renderItem = ({ item , index}) => {
    
   return (
      <View style={styles.itemSet}>
          <TouchableHighlight
            onPress = {onPress(item, index)} 
          >
              <View>

         <Text>{`${index} item.name : ${item.name}`}</Text>

              </View>

         </TouchableHighlight>
         {
             item.show?
             <View>
                 <Text>{`item.id : ${item.id}`}</Text>
                 <Text>{`item.password : ${item.password}`}</Text>
            </View>
             :null
         }

        
      </View>
     
   );
};
const styles = StyleSheet.create({
   itemSet: {
      padding: 10,
   },
});