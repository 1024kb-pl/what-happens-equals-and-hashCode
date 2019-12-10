package pl.blog.spring;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserWithGeneratedEqualsAndHashCodeTest implements WithAssertions {
    @Test
    void shouldReturnUserFromMap() {
        //given
        User user = new UserWithGeneratedEqualsAndHashCode(1, "Pablo", 10);
        Map<User, List<String>> map = new HashMap<>();
        map.put(user, Collections.singletonList("Value1"));

        //when
        List<String> values = map.get(user);

        //then
        assertThat(values)
                .hasSize(1)
                .contains("Value1");
    }

    @Test
    void shouldReturnUserFromMapWhenGetValueUsingCopyOfKey() {
        //given
        User user = new UserWithGeneratedEqualsAndHashCode(1, "Pablo", 10);
        User pablo = new UserWithGeneratedEqualsAndHashCode(1, "Pablo", 10);
        Map<User, List<String>> map = new HashMap<>();
        map.put(user, Collections.singletonList("Value1"));

        //when
        List<String> values = map.get(pablo);

        //then
        assertThat(values)
                .hasSize(1)
                .contains("Value1");
    }

    @Test
    void shouldReturnUserFromMapEvenWhenUserStateHasChanged() {
        //given
        User user = new UserWithGeneratedEqualsAndHashCode(1, "Pablo", 10);
        Map<User, List<String>> map = new HashMap<>();
        map.put(user, Collections.singletonList("Value1"));

        //when
        user.setAge(15);
        List<String> values = map.get(user);

        //then
        assertThat(values)
                .hasSize(1)
                .contains("Value1");
    }
}