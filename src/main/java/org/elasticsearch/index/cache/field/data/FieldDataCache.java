/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.cache.field.data;

import org.apache.lucene.index.IndexReader;
import org.elasticsearch.common.component.CloseableComponent;
import org.elasticsearch.index.IndexComponent;
import org.elasticsearch.index.field.data.FieldData;
import org.elasticsearch.index.field.data.FieldDataType;

import java.io.IOException;

/**
 *
 */
public interface FieldDataCache extends IndexComponent, CloseableComponent {

    FieldData cache(FieldDataType type, IndexReader reader, String fieldName) throws IOException;

    String type();

    void clear(String reason, String fieldName);

    void clear(String reason);

    void clear(IndexReader reader);

    long evictions();

    long sizeInBytes();

    long sizeInBytes(String fieldName);
}
