import { FlatList, Text, View, ViewBase } from "react-native";

const PostScreen = ({post}) => {
    return (
        
            <FlatList
                data = {post}
                renderItem = {(item) => renderItem(item) }
            >
            </FlatList>
        
    )
}

const renderItem = (item) => {
    return(
        <View style={{margin:10, borderColor:"gray", borderWidth:1}}>
            <Text>
                {item.userName}
            </Text>
            <Image source = {`${IMG_PATH}${item.img}`} style={{width:100, height: 100}}></Image>
            <Text>{item.content}</Text>
        </View>
    )
}

export default PostScreen;