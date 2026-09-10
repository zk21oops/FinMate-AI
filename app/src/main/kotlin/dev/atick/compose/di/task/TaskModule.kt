package dev.atick.compose.di.task

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.compose.worker.TaskManager
import dev.atick.compose.worker.TaskManagerImpl
import javax.inject.Singleton

/**
 * Dagger module that provides the binding for the [TaskManager] interface.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class TaskModule {

    /**
     * Binds the [TaskManagerImpl] implementation to the [TaskManager] interface.
     *
     * @param taskManagerImpl The implementation of [TaskManager] to be bound.
     * @return The [TaskManager] interface.
     */
    @Binds
    @Singleton
    abstract fun bindTaskManager(taskManagerImpl: TaskManagerImpl): TaskManager
}
