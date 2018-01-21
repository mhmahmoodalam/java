com.ex.capability;

import java.util.List;

import javax.transaction.UserTransaction;

import com.ex.dto.RequestParams;
import com.ex.exception.ApplicationServiceException;
import net.ex.model.ServiceModel;

/**
 * Interface for ServiceModel book capability
 * 
 * @author x6bt
 *
 */
public interface Capability {

    /**
     * @return ServiceCapabilityImpl
     */
    CapabilityValidation getCapabilityValidation();

    /**
     * @param capabilityValidation
     *            ServiceCapabilityValidation
     */
    void setCapabilityValidation(
            final CapabilityValidation capabilityValidation);

    /**
     * @return ServiceDao
     */
   // ServiceDao getServiceDao();

    /**
     * @param ServiceDao
     *            ServiceDao
     */
   // void setServiceDao(ServiceDao ServiceDao);

    /**
     * API to add an ServiceModel record in personal contact table
     * 
     * @param requestParams
     *            RequestParams
     * @param userTransaction
     *            UserTransaction
     * @param validateCustomerId
     *            boolean
     * @return ServiceModel
     * @throws ApplicationServiceException
     *             If an error occurs
     * @throws CacheUtilityExceptionCU
     *             If an error occurs while retrieving cached data
     * @throws TransactionUtilityException
     *             If an error occurs in the transaction
     */
    ServiceModel addServiceModel(final RequestParams requestParams,
            final UserTransaction userTransaction,
            final boolean validateCustomerId)
                    throws ApplicationServiceException,
                    CacheUtilityExceptionCU, TransactionUtilityException;

    

    /**
     * Api to retrieve to get the health status
     * 
     * @throws ApplicationServiceException
     *             ApplicationServiceException If an error occurs
     */
    void getHealthCheckStatus() throws ApplicationServiceException;
}
