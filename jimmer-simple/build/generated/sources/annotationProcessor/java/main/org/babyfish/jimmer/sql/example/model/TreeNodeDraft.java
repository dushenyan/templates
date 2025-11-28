package org.babyfish.jimmer.sql.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToOne;
import org.babyfish.jimmer.sql.OneToMany;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@GeneratedBy(
        type = TreeNode.class
)
public interface TreeNodeDraft extends TreeNode, Draft {
    TreeNodeDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    TreeNodeDraft setId(long id);

    @OldChain
    TreeNodeDraft setName(String name);

    @Nullable
    TreeNodeDraft parent();

    TreeNodeDraft parent(boolean autoCreate);

    @OldChain
    TreeNodeDraft setParent(TreeNode parent);

    @Nullable
    @JsonIgnore
    Long parentId();

    @OldChain
    TreeNodeDraft setParentId(@Nullable Long parentId);

    @OldChain
    TreeNodeDraft applyParent(DraftConsumer<TreeNodeDraft> block);

    @OldChain
    TreeNodeDraft applyParent(TreeNode base, DraftConsumer<TreeNodeDraft> block);

    List<TreeNodeDraft> childNodes(boolean autoCreate);

    @OldChain
    TreeNodeDraft setChildNodes(List<TreeNode> childNodes);

    @OldChain
    TreeNodeDraft addIntoChildNodes(DraftConsumer<TreeNodeDraft> block);

    @OldChain
    TreeNodeDraft addIntoChildNodes(TreeNode base, DraftConsumer<TreeNodeDraft> block);

    @GeneratedBy(
            type = TreeNode.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_NAME = 1;

        public static final int SLOT_PARENT = 2;

        public static final int SLOT_CHILD_NODES = 3;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.114",
                TreeNode.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (TreeNode)base)
            )
            .id(SLOT_ID, "id", long.class)
            .key(SLOT_NAME, "name", String.class, false)
            .keyReference(SLOT_PARENT, "parent", ManyToOne.class, TreeNode.class, true)
            .add(SLOT_CHILD_NODES, "childNodes", OneToMany.class, TreeNode.class, false)
            .build();

        private Producer() {
        }

        public TreeNode produce(DraftConsumer<TreeNodeDraft> block) {
            return (TreeNode)Internal.produce(TYPE, null, block);
        }

        public TreeNode produce(TreeNode base, DraftConsumer<TreeNodeDraft> block) {
            return (TreeNode)Internal.produce(TYPE, base, block);
        }

        public TreeNode produce(boolean resolveImmediately, DraftConsumer<TreeNodeDraft> block) {
            return (TreeNode)Internal.produce(TYPE, null, resolveImmediately, block);
        }

        public TreeNode produce(TreeNode base, boolean resolveImmediately,
                DraftConsumer<TreeNodeDraft> block) {
            return (TreeNode)Internal.produce(TYPE, base, resolveImmediately, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = TreeNode.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "name", "parent", "childNodes"})
        public abstract static class Implementor implements TreeNode, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_NAME:
                    		return name();
                    case SLOT_PARENT:
                    		return parent();
                    case SLOT_CHILD_NODES:
                    		return childNodes();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "name":
                    		return name();
                    case "parent":
                    		return parent();
                    case "childNodes":
                    		return childNodes();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getName() {
                return name();
            }

            @org.jetbrains.annotations.Nullable
            public final TreeNode getParent() {
                return parent();
            }

            public final List<TreeNode> getChildNodes() {
                return childNodes();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = TreeNode.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __nameValue;

            TreeNode __parentValue;

            boolean __parentLoaded = false;

            NonSharedList<TreeNode> __childNodesValue;

            @Override
            @JsonIgnore
            @Description("The surrogate id of the current object,\n"
                            + "auto-incrementing,\n"
                            + "without specific business meaning")
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(TreeNode.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            @Description("The name of current TreeNode.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint,\n"
                            + "which is {@code @Key} of Jimmer</p>")
            public String name() {
                if (__nameValue == null) {
                    throw new UnloadedException(TreeNode.class, "name");
                }
                return __nameValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            @Description("The parent node of the current TreeNode.\n"
                            + "The type of the associated object is the\n"
                            + "same as the current object type, so it\n"
                            + "is a self-associated property that can\n"
                            + "be queried recursively.")
            public TreeNode parent() {
                if (!__parentLoaded) {
                    throw new UnloadedException(TreeNode.class, "parent");
                }
                return __parentValue;
            }

            @Override
            @JsonIgnore
            @Description("The child nodes of the current TreeNode.\n"
                            + "The type of the associated object is the\n"
                            + "same as the current object type, so it\n"
                            + "is a self-associated property that can\n"
                            + "be queried recursively.")
            public List<TreeNode> childNodes() {
                if (__childNodesValue == null) {
                    throw new UnloadedException(TreeNode.class, "childNodes");
                }
                return __childNodesValue;
            }

            @Override
            public Impl clone() {
                try {
                    Impl copy = (Impl) super.clone();
                    Visibility originalVisibility = this.__visibility;
                    if (originalVisibility != null) {
                        Visibility newVisibility = Visibility.of(4);
                        for (int propId = 0; propId < 4; propId++) {
                            newVisibility.show(propId, originalVisibility.visible(propId));
                        }
                        copy.__visibility = newVisibility;
                    } else {
                        copy.__visibility = null;
                    }
                    return copy;
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_NAME:
                    		return __nameValue != null;
                    case SLOT_PARENT:
                    		return __parentLoaded;
                    case SLOT_CHILD_NODES:
                    		return __childNodesValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "name":
                    		return __nameValue != null;
                    case "parent":
                    		return __parentLoaded;
                    case "childNodes":
                    		return __childNodesValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_NAME:
                    		return __visibility.visible(SLOT_NAME);
                    case SLOT_PARENT:
                    		return __visibility.visible(SLOT_PARENT);
                    case SLOT_CHILD_NODES:
                    		return __visibility.visible(SLOT_CHILD_NODES);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "name":
                    		return __visibility.visible(SLOT_NAME);
                    case "parent":
                    		return __visibility.visible(SLOT_PARENT);
                    case "childNodes":
                    		return __visibility.visible(SLOT_CHILD_NODES);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__nameValue != null) {
                    hash = 31 * hash + __nameValue.hashCode();
                }
                if (__parentLoaded && __parentValue != null) {
                    hash = 31 * hash + __parentValue.hashCode();
                }
                if (__childNodesValue != null) {
                    hash = 31 * hash + __childNodesValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__nameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__nameValue);
                }
                if (__parentLoaded) {
                    hash = 31 * hash + System.identityHashCode(__parentValue);
                }
                if (__childNodesValue != null) {
                    hash = 31 * hash + System.identityHashCode(__childNodesValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && !Objects.equals(__nameValue, __other.name())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PARENT)) != __other.__isVisible(PropId.byIndex(SLOT_PARENT))) {
                    return false;
                }
                boolean __parentLoaded = this.__parentLoaded;
                if (__parentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PARENT))) {
                    return false;
                }
                if (__parentLoaded && !Objects.equals(__parentValue, __other.parent())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CHILD_NODES)) != __other.__isVisible(PropId.byIndex(SLOT_CHILD_NODES))) {
                    return false;
                }
                boolean __childNodesLoaded = __childNodesValue != null;
                if (__childNodesLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CHILD_NODES))) {
                    return false;
                }
                if (__childNodesLoaded && !Objects.equals(__childNodesValue, __other.childNodes())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && __nameValue != __other.name()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PARENT)) != __other.__isVisible(PropId.byIndex(SLOT_PARENT))) {
                    return false;
                }
                boolean __parentLoaded = this.__parentLoaded;
                if (__parentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PARENT))) {
                    return false;
                }
                if (__parentLoaded && __parentValue != __other.parent()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CHILD_NODES)) != __other.__isVisible(PropId.byIndex(SLOT_CHILD_NODES))) {
                    return false;
                }
                boolean __childNodesLoaded = __childNodesValue != null;
                if (__childNodesLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CHILD_NODES))) {
                    return false;
                }
                if (__childNodesLoaded && __childNodesValue != __other.childNodes()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = TreeNode.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, TreeNodeDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private TreeNode __resolved;

            DraftImpl(DraftContext ctx, TreeNode base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public TreeNodeDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String name() {
                return (__modified!= null ? __modified : __base).name();
            }

            @Override
            public TreeNodeDraft setName(String name) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (name == null) {
                    throw new IllegalArgumentException(
                        "'name' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__nameValue = name;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public TreeNodeDraft parent() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).parent());
            }

            @Override
            public TreeNodeDraft parent(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_PARENT)) || parent() == null)) {
                    setParent(TreeNodeDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).parent());
            }

            @Override
            public TreeNodeDraft setParent(TreeNode parent) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__parentValue = parent;
                __tmpModified.__parentLoaded = true;
                return this;
            }

            @Nullable
            @JsonIgnore
            @Override
            public Long parentId() {
                TreeNode parent = parent();
                if (parent == null) {
                    return null;
                }
                return parent.id();
            }

            @OldChain
            @Override
            public TreeNodeDraft setParentId(@Nullable Long parentId) {
                if (parentId == null) {
                    setParent(null);
                    return this;
                }
                parent(true).setId(parentId);
                return this;
            }

            @Override
            public TreeNodeDraft applyParent(DraftConsumer<TreeNodeDraft> block) {
                applyParent(null, block);
                return this;
            }

            @Override
            public TreeNodeDraft applyParent(TreeNode base, DraftConsumer<TreeNodeDraft> block) {
                setParent(TreeNodeDraft.$.produce(base, block));
                return this;
            }

            @Override
            @JsonIgnore
            public List<TreeNode> childNodes() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).childNodes(), TreeNode.class, true);
            }

            @Override
            public List<TreeNodeDraft> childNodes(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_CHILD_NODES)))) {
                    setChildNodes(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).childNodes(), TreeNode.class, true);
            }

            @Override
            public TreeNodeDraft setChildNodes(List<TreeNode> childNodes) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (childNodes == null) {
                    throw new IllegalArgumentException(
                        "'childNodes' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__childNodesValue = NonSharedList.of(__tmpModified.__childNodesValue, childNodes);
                return this;
            }

            @Override
            public TreeNodeDraft addIntoChildNodes(DraftConsumer<TreeNodeDraft> block) {
                addIntoChildNodes(null, block);
                return this;
            }

            @Override
            public TreeNodeDraft addIntoChildNodes(TreeNode base,
                    DraftConsumer<TreeNodeDraft> block) {
                childNodes(true).add((TreeNodeDraft)TreeNodeDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_NAME:
                    		setName((String)value);break;
                    case SLOT_PARENT:
                    		setParent((TreeNode)value);break;
                    case SLOT_CHILD_NODES:
                    		setChildNodes((List<TreeNode>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "name":
                    		setName((String)value);break;
                    case "parent":
                    		setParent((TreeNode)value);break;
                    case "childNodes":
                    		setChildNodes((List<TreeNode>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_NAME:
                    		__visibility.show(SLOT_NAME, visible);break;
                    case SLOT_PARENT:
                    		__visibility.show(SLOT_PARENT, visible);break;
                    case SLOT_CHILD_NODES:
                    		__visibility.show(SLOT_CHILD_NODES, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "name":
                    		__visibility.show(SLOT_NAME, visible);break;
                    case "parent":
                    		__visibility.show(SLOT_PARENT, visible);break;
                    case "childNodes":
                    		__visibility.show(SLOT_CHILD_NODES, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_NAME:
                    		__modified().__nameValue = null;break;
                    case SLOT_PARENT:
                    		__modified().__parentValue = null;
                    __modified().__parentLoaded = false;break;
                    case SLOT_CHILD_NODES:
                    		__modified().__childNodesValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "name":
                    		__modified().__nameValue = null;break;
                    case "parent":
                    		__modified().__parentValue = null;
                    __modified().__parentLoaded = false;break;
                    case "childNodes":
                    		__modified().__childNodesValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.TreeNode\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_PARENT))) {
                            TreeNode oldValue = base.parent();
                            TreeNode newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setParent(newValue);
                            }
                        }
                        if (base.__isLoaded(PropId.byIndex(SLOT_CHILD_NODES))) {
                            List<TreeNode> oldValue = base.childNodes();
                            List<TreeNode> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setChildNodes(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__parentValue = __ctx.resolveObject(__tmpModified.__parentValue);
                        __tmpModified.__childNodesValue = NonSharedList.of(__tmpModified.__childNodesValue, __ctx.resolveList(__tmpModified.__childNodesValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = TreeNode.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            this(null);
        }

        public Builder(@Nullable TreeNode base) {
            __draft = new Producer.DraftImpl(null, base);
        }

        public Builder id(@NonNull Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder name(@NonNull String name) {
            if (name != null) {
                __draft.setName(name);
            }
            return this;
        }

        public Builder parent(@Nullable TreeNode parent) {
            __draft.setParent(parent);
            return this;
        }

        public Builder childNodes(@NonNull List<TreeNode> childNodes) {
            if (childNodes != null) {
                __draft.setChildNodes(childNodes);
            }
            return this;
        }

        public TreeNode build() {
            return (TreeNode)__draft.__modified();
        }
    }
}
