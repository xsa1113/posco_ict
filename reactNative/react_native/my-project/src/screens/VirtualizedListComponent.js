import { StyleSheet } from "react-native";
import { SafeAreaView, Text, VirtualizedList } from "react-native";
import { View} from "react-native";


const DATA  = new Array(100).fill(1).map((data,i)=>i);
const getItem = (data, index) => ({
    id: data,
    title: `title ${data}`
})

const getItemCount = (data) => 100
const VirtualizedListComponent = () => {
    return(
        <SafeAreaView>
            <VirtualizedList
                data = {DATA}
                initialNumToRender = {5}
                renderItem ={({item}) => 
                <View style = {styles.section}>
                    <Text>{item.title}</Text>
                </View>}
                getItemCount={getItemCount}
                getItem={getItem}
            >
            </VirtualizedList>
        </SafeAreaView>
    )
}

export default VirtualizedListComponent;
const styles = StyleSheet.create({
   section: {padding:10} 
});